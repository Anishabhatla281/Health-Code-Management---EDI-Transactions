package editransactions



import grails.test.mixin.*
import org.junit.*
import grails.test.GrailsUnitTestCase
import grails.test.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */

class AllServicesServiceTests extends GrailsUnitTestCase{

    void testCheckBeforeUpload(){
        AllServicesService service = new AllServicesService()
        File file1 = new File("test1.txt")
        FileWriter fstream1 = new FileWriter("test1.txt")
        BufferedWriter out1 = new BufferedWriter(fstream1)
        out1.write("ST*997*005010x230~")
        out1.close()
        String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        session.dest=dest
        boolean success = (new java.io.File(dest)).mkdir()
        File destination = new File(dest + "test1.txt")
        boolean ch = service.checkBeforeUpload("test1.txt",file1,destination)
        assertEquals(true,ch)

    }

    void testStCheckBeforeUpload(){
        AllServicesService service = new AllServicesService()
        File file1 = new File("test1.txt")
        FileWriter fstream1 = new FileWriter("test1.txt")
        BufferedWriter out1 = new BufferedWriter(fstream1)
        out1.write("ST*005010x230~")
        out1.close()
        String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        session.dest=dest
        boolean success = (new java.io.File(dest)).mkdir()
        File destination = new File(dest + "test1.txt")
        boolean ch = service.checkBeforeUpload("test1.txt",file1,destination)
        assertEquals(false,ch)

    }

    void testExtensionCheckBeforeUpload(){
        AllServicesService service = new AllServicesService()
        File file1 = new File("test1.mp3")
        String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        session.dest=dest
        boolean success = (new java.io.File(dest)).mkdir()
        File destination = new File(dest + "test1.mp3")
        boolean ch = service.checkBeforeUpload("test1.mp3",file1,destination)
        assertEquals(false,ch)
    }
    void testAlreadyExists(){

        AckFile ackFile=new AckFile(fileName: "test1.txt",stCode: "005010x230")
        mockDomain(AckFile,[ackFile])
        AllServicesService service = new AllServicesService()
        File file1 = new File("test1.txt")
        String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        session.dest=dest
        boolean success = (new java.io.File(dest)).mkdir()
        File destination = new File(dest + "test1.txt")
        String ch = service.checkBeforeUpload("test1.txt",file1,destination)
        assertEquals("already Exists",ch)
    }

    void testSaveIntoDataBase(){
        File file1 = new File("test1.txt")
        FileWriter fstream1 = new FileWriter("test1.txt")
        BufferedWriter out1 = new BufferedWriter(fstream1)
        out1.write("ST*997*005010x230~")
        out1.newLine()
        out1.write("AK9*a*2*a*2~")
        out1.close()
        String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        session.dest=dest
        boolean success = (new java.io.File(dest)).mkdir()
        File destination = new File(dest + "test1.txt")
        AllServicesService service = new AllServicesService()
        boolean ch=service.saveIntoDataBase("test1.txt","test1.txt")
        assertEquals(false,ch)

    }

    void testSaveIntoDataBaseValid(){
        File file1 = new File("test1.txt")
        FileWriter fstream1 = new FileWriter("test1.txt")
        BufferedWriter out1 = new BufferedWriter(fstream1)
        out1.write("ST*997*005010x230~")
        out1.newLine()
        out1.write("AK9*a*2*1*2~")
        out1.close()
        String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        session.dest=dest
        boolean success = (new java.io.File(dest)).mkdir()
        File destination = new File(dest + "test1.txt")
        AllServicesService service = new AllServicesService()
        boolean ch=service.saveIntoDataBase("test1.txt","test1.txt")
        assertEquals(true,ch)


    }
    void testInvalidSave(){
        File file1 = new File("test1.txt")
        FileWriter fstream1 = new FileWriter("test1.txt")
        BufferedWriter out1 = new BufferedWriter(fstream1)
        out1.write("ST*997~")
        out1.newLine()
        out1.write("AK9*a*2*1*2~")
        out1.close()
        String dest = "C:\\Users\\anisbhat\\IdeaProjects\\EDItransactions\\web-app\\uploadedFiles\\"
        session.dest=dest
        boolean success = (new java.io.File(dest)).mkdir()
        File destination = new File(dest + "test1.txt")
        AllServicesService service = new AllServicesService()
        boolean ch=service.saveIntoDataBase("test1.txt","test1.txt")
        assertEquals(false,ch)
    }

}
