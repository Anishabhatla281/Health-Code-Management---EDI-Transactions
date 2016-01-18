package editransactions

class AllServicesService {

    def checkBeforeUpload(def name,def file,def destination) {
        def result
        AckFile ackFile = AckFile.findByFileName(name)
        String []str1
        if (!file.isEmpty() ){
            String sFile = file.getOriginalFilename()
            if (sFile.endsWith(".txt") || sFile.endsWith(".TXT") || sFile.endsWith(".dat") || sFile.endsWith(".DAT") || sFile.endsWith(".edi")||sFile.endsWith(".EDI")){
                    if(ackFile!=null)
                   return "already Exists"
                else
                file.transferTo(destination)
            try{FileReader f=new FileReader(destination)
                BufferedReader b=new BufferedReader(f)
                String str2
                def flag
                def i=0
                def j=0
                while((str2=b.readLine())!=null)
                {   i=0
                    str1=str2.split("[~]")
                    while(i<str1.length){
                        if(str1[i].startsWith("ST*997*"))
                            return true
                        i++
                    }
                }
                b.close()
                destination.delete()
                return false
            }
            catch(Exception e)
            {
                println "Invalid File Exception"
            }
            }
            else{
                return false
            }
        }
        }

    AckFile saveIntoDataBase(String filePath, String fileName){
        String []str1
        String[] str3
        AckFile ackFile = new AckFile()
        ackFile.fileName = fileName
        def count=0  
        FileReader f=new FileReader(filePath)
        BufferedReader b=new BufferedReader(f)
        String str2
        def flag
        def i=0
        def j
        while((str2=b.readLine())!=null)
            {   i=0
                str1=str2.split("[~]")
                while(i<str1.length){
                    j = 0
                    str3=str1[i].split("[*]")
                    while(j<str3.length){
                       switch(str3[j])
                        {   case "AK1":                                                                                                                                 if (!str3[1].equals("") )
                                ackFile.funcIdentifierCode = str3[1]
                                if(str3.size()>3)
                                if(!str3[3].equals(""))
                                ackFile.versionCustom=str3[3]

                            case "AK2":
                                if (!str3[1].equals("") )
                                ackFile.transIdentifierCode=str3[1]

                            case "AK3":
                                if (!str3[1].equals(""))
                                 ackFile.idCode=str3[1]
                                if(str3.size()>2)
                                if (!str3[2].equals(""))
                                  ackFile.transPos=str3[2]
                                if(str3.size()>4)
                                if (!str3[4].equals(""))
                                  ackFile.errorCode=str3[4]

                            case "AK4":
                                if (!str3[1].equals(""))
                                ackFile.dataPos=str3[1]
                                if(str3.size()>2)
                                if (!str3[2].equals(""))
                                ackFile.dataElementPos=str3[2]
                                if(str3.size()>3)
                                if (!str3[3].equals(""))
                                ackFile.dataElementRef=str3[3]

                            case "AK5":
                                if (!str3[1].equals(""))
                                ackFile.ackCode=str3[1]
                                if(str3.size()>2)
                                if (!str3[2].equals(""))
                                ackFile.transErrorCode=str3[2]

                           case "AK9":
                                if (!str3[1].equals(""))
                                ackFile.funcAckCode=str3[1]
                                if(str3.size()>2)
                                if (!str3[2].equals(""))
                                ackFile.transSets=Integer.valueOf(str3[2])
                                if(str3.size()>3)
                                if (!str3[3].equals(""))
                                ackFile.accSets=Integer.valueOf(str3[3])
                                if(str3.size()>4)
                                if (!str3[4].equals(""))
                                ackFile.recSets=Integer.valueOf(str3[4])

                           case "ST": if(str3.size()>3)
                                if (str3[3].equals("005010X230"))
                                ackFile.stCode = str3[3]
                        }
                       
                        j++
                    }
                    i++
                }
            }
           b.close()
           if(ackFile.validate())
           { ackFile.save()
               return true}
        else
               return false

       }

    }



