package editransactions

class AckFile {

    String fileName
    String stCode
    String funcIdentifierCode
    String versionCustom
    String transIdentifierCode
    String idCode
    String transPos
    String errorCode
    String dataPos
    String dataElementPos
    String dataElementRef
    String ackCode
    String transErrorCode
    String funcAckCode
    Integer transSets
    Integer recSets
    Integer accSets

    static constraints = {
        fileName(nullable: true, blank: true)
        stCode(nullable: false, blank: false)
        funcIdentifierCode(nullable: true, blank: true)
        versionCustom(nullable: true, blank: true)
        transIdentifierCode(nullable: true, blank: true)
        idCode(nullable: true, blank: true)
        transPos(nullable: true, blank: true)
        errorCode(nullable: true, blank: true,inList: ['1','2','3','4','5','6','7','8'] )
        dataPos(nullable: true, blank: true)
        dataElementPos(nullable: true, blank: true)
        dataElementRef(nullable: true, blank: true, inList: ['1','2','3','4','5','6','7','8','9','10','12','13'])
        ackCode(nullable: true, blank: true, inList: ['A','E','M','R','W','X'])
        transErrorCode(nullable: true, blank: true, inList: ['1','2','3','4','5','6','7','8','9','10','11','12','13','15','16','17','18','19','23','24','25','26','27'])
        funcAckCode(nullable: true, blank: true, inList: ['A','E','M','P','R','W','X'])
        transSets(nullable: true, blank: true)
        recSets(nullable: true, blank: true)
        accSets(nullable: true, blank: true)
    }
}
