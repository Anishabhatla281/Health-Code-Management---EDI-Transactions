package editransactions



import grails.test.mixin.*
import org.junit.*
import grails.test.*
import grails.test.GrailsUnitTestCase

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

class AckFileTests extends GrailsUnitTestCase{
    def grail

    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

     void testValidFile()
     {
         def testInstances=[new AckFile(fileName: "997.txt",stCode: "005010X230",funcIdentifierCode: "HC",versionCustom: "005010",transIdentifierCode: "837",idCode: "CLM",transPos: "22",errorCode:"8",dataPos: "1",dataElementPos: "1028",dataElementRef: "1", ackCode: "R", transErrorCode: "5",funcAckCode: "P",transSets: 2,recSets: 3,accSets: 4 )]
         mockDomain(AckFile, testInstances)
         assertEquals(1, AckFile.count())
     }

    void testInvalidStCodeNull()
    {
        def testInstances=new AckFile(fileName: "997.txt",funcIdentifierCode: "HC",versionCustom: "005010",transIdentifierCode: "837",idCode: "CLM",transPos: "22",errorCode:"8",dataPos: "1",dataElementPos: "1028",dataElementRef: "1", ackCode: "R", transErrorCode: "5",funcAckCode: "P",transSets: 2,recSets: 3,accSets: 4 )
        mockForConstraintsTests(AckFile, [testInstances])
        assertFalse(testInstances.validate())
        assertEquals("nullable",testInstances.errors["stCode"])
    }
    void testConstraints()
    {
        def testInstances=new AckFile(stCode: "005010X230", funcIdentifierCode: "HC",versionCustom: "005010",transIdentifierCode: "837",idCode: "CLM",transPos: "22",errorCode:"8",dataPos: "1",dataElementPos: "1028",dataElementRef: "1", ackCode: "R", transErrorCode: "5",funcAckCode: "P",transSets: 2,recSets: 3,accSets: 4 )
        mockForConstraintsTests(AckFile, [testInstances])
        assertTrue(testInstances.validate())
    }
    void testInListConstraint(){
        def testInstances=new AckFile(stCode: "005010X230", funcIdentifierCode: "HC",versionCustom: "005010",transIdentifierCode: "837",idCode: "CLM",transPos: "22",errorCode:"9",dataPos: "1",dataElementPos: "1028",dataElementRef: "1", ackCode: "R", transErrorCode: "5",funcAckCode: "P",transSets: 2,recSets: 3,accSets: 4 )
        mockForConstraintsTests(AckFile, [testInstances])
        assertFalse(testInstances.validate())
        assertEquals("inList",testInstances.errors["errorCode"])
    }
}
