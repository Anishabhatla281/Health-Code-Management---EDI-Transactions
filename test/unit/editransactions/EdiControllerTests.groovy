package editransactions



import grails.test.mixin.*
import org.junit.*
import com.mysql.jdbc.PacketTooBigException

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(EdiController)
class EdiControllerTests extends grails.test.ControllerUnitTestCase{

    void testEditing(){
        mockDomain(AckFile,[new AckFile(fileName: "test1.txt",stCode: "005010x230")])
        mockParams.filename("test1.txt")
        def model = controller.editing()
        assertEquals "editing",renderArgs.view
        assertEquals  1,renderArgs.model.ackFile.id
        assertEquals "test1.txt",renderArgs.model.ackFile.fileName

    }

    void testInvalidEditing(){
        mockDomain(AckFile,[new AckFile(fileName: "test1.txt",stCode: "005010x230")])
        mockParams.filename("test2.txt")
        def model = controller.editing()
        assertEquals "editUsingName",renderArgs.view

    }
    void testChange(){
        AckFile ackFile2 = new AckFile(fileName: "test1.txt",stCode: "005010x230")
        mockDomain(AckFile,[ackFile2])
        session.ackFile=ackFile2
        mockParams.fileName="test2.txt"
        mockParams.stCode="0050"
        def model = controller.change()
        assertEquals "check",renderArgs.view
    }
    void testInvalidChange(){
        AckFile ackFile2 = new AckFile(fileName: "test1.txt",stCode: "005010x230")
        mockDomain(AckFile,[ackFile2])
        session.ackFile=ackFile2
        mockParams.fileName="test2.txt"
        def model = controller.change()
        assertEquals "editing",renderArgs.view
    }

    void testDisplay(){
        mockDomain(AckFile,[new AckFile(fileName: "test1.txt",stCode: "0050"), new AckFile(fileName: "test2.txt",stCode: "0040")])
        def model=controller.display()
        assertEquals "display",renderArgs.vew
    }
    void testDeleting(){
        mockDomain(AckFile,[new AckFile(fileName: "test1.txt",stCode: "0050")])
        mockParams.filename="test1.txt"
        def model = controller.deleting()
        assertEquals "check",renderArgs.view
    }
    void testInvalidDeleting(){
        mockDomain(AckFile,[new AckFile(fileName: "test1.txt",stCode: "0050")])
        mockParams.filename=" "
        def model = controller.deleting()
        assertEquals "deleteUsingName",renderArgs.view
    }
    void testDeleteAll(){
        mockDomain(AckFile,[new AckFile(fileName: "test1.txt",stCode: "0050") new AckFile(fileName: "test2.txt",stCode: "0040")])
        def model = controller.deleteAll()
        assertEquals "check",renderArgs.view
        assertEquals 0,AckFile.size()
    }

}
