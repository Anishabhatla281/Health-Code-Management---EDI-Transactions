package editransactions

import editransactions.AckFile
import groovy.io.FileType
//import grails.plugins.springsecurity.Secured

class EdiController {

    AllServicesService service = new AllServicesService()
    def index= {
            }
    //@Secured(['IS_AUTHENTICATED_FULLY'])
    def uploadFile={      def ackFileInstance = new AckFile()
    }
   // @Secured(['IS_AUTHENTICATED_FULLY'])
    def upload = {
        def ackFileInstance = new AckFile()
        def result
        def cntUpload = 0
        def uploaded = 0
        def message =""
        def file
        File destination
        String filePath
        String fileName
        Iterator itr = request.getFileNames()
        String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        session.setAttribute("dest",dest)
        boolean success = (new java.io.File(dest)).mkdir()
        while(itr.hasNext()) {
            file = request.getFile(itr.next())
            destination = new File(dest + file.getOriginalFilename())
            cntUpload++
            String name=file.getOriginalFilename()
            def b=service.checkBeforeUpload(name,file,destination)
            if (b==true){
            message+= "File uploaded successfully and saved into database! "+"<br/>"
            filePath = dest + file.getOriginalFilename()
            fileName = file.getOriginalFilename()
            boolean ch=service.saveIntoDataBase(filePath,fileName)
              if(ch ==true) { flash.message=message
                render(view: "check")}
                else
              {flash.message="Invalid Content Of File. Failed Validations/Constraints!"}
                render(view: "check")
            }
            else if (b==false){
                message+= "File Is Not A Valid 997 text/dat/edi File! " +"<br/>"
                flash.message1=message
                render(view: "uploadFile", model: [ackFileInstance: ackFileInstance])
        }
            else if (b.equals("already Exists")){
            message+="File Already Exists!"
            flash.message1=message
            render(view: "uploadFile", model: [ackFileInstance: ackFileInstance])
            }
        }
    }
   // @Secured(['IS_AUTHENTICATED_FULLY'])
    def check={
        def ackFileInstance = new AckFile()
       
    }
   // @Secured(['IS_AUTHENTICATED_FULLY'])
    def editing={
               def ackFileInstance = new AckFile()
               def filename = params.filename
               AckFile ackFile = AckFile.findByFileName(filename)
               if (params.filename.equals("")||(params.filename.startsWith(" "))){
               flash.message2="Please enter the file name!"
               render(view: "editUsingName")
                }
               else if (ackFile==null){
               flash.message2=params.filename+" doesn't exist!"
               render(view:  "editUsingName", model: [ackFileInstance: ackFileInstance])
              }
              else{
               String errorCode = ackFile.errorCode
               String dataRefNumber = ackFile.dataElementRef
               String transErrorCode = ackFile.transErrorCode
               String tAckCode = ackFile.ackCode
               String fAckCode = ackFile.funcAckCode
               session.setAttribute("ackFile",ackFile)
               render(view:  "editing", model: [errorCode: errorCode, dataRefNumber: dataRefNumber, tAckCode: tAckCode, fAckCode: fAckCode, transErrorCode: transErrorCode, filename: filename, ackFile: ackFile])
              }

    }
  //  @Secured(['IS_AUTHENTICATED_FULLY'])
    def change={
        AckFile ackFile = session.getAttribute("ackFile")
        ackFile.properties = params
        if(ackFile.validate())
        { ackFile.save()
          flash.message="Changed Successfully!"
          render(view: "check")}
        else
        {   flash.message="Changes Unsuccessful!"
            render(view: "editing", model: [ackFile: ackFile])
        }
    }
   // @Secured(['IS_AUTHENTICATED_FULLY'])
    def editUsingName={    }

    // @Secured(['IS_AUTHENTICATED_FULLY'])
    def info={   }

    //@Secured(['IS_AUTHENTICATED_FULLY'])
    def display={
        def ackFileInstance = new AckFile()
        def files = AckFile.list(sort: 'id', order:'desc')
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [files:files, AckFileInstanceTotal: AckFile.count()]


        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [designationInstanceList: Designation.list(params), designationInstanceTotal: Designation.count()]


    }
    
   // @Secured(['IS_AUTHENTICATED_FULLY'])
    def deleteUsingName={    }

    def loginPage={     }
    
   // @Secured(['IS_AUTHENTICATED_FULLY'])
    def deleting={
        def ackFileInstance = new AckFile()
        def filename = params.filename
        def count=0
        if (params.filename.equals("")||(params.filename.startsWith(" "))){
            flash.message3="Please enter the correct file name!"
            render(view: "deleteUsingName")
        }
        else{
        ArrayList listing = AckFile.findAllByFileName(filename)
            if (listing!=null){
            for (Iterator i=listing.iterator();i.hasNext();){
          AckFile ackFile= i.next()
          ackFile.delete()
           flash.message=filename+" deleted successfully!"
            render(view: "check")
        }
            }
       /* String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        String finalDest = dest+filename
        File finalD = new File(finalDest)
            if (finalD==null)println "null hai !!"
            println finalD*/
       /*  if (count ==1)
        {  flash.message=filename+" deleted successfully!"
            render(view: "check")}*/
        else
        { flash.message3=filename+" doesn't exist!"
            render(view: "deleteUsingName")
        }
        }
    }
        def deleteAll={
            ArrayList all = AckFile.findAll()
            if (all!=null){
                for (Iterator i=all.iterator();i.hasNext();){
                    AckFile ackFile= i.next()
                    ackFile.delete()
                }
                flash.message="All Files Deleted Successfully!"
                render(view: "check")
        }

    }
}

