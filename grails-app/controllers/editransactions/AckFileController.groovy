package editransactions

import org.springframework.dao.DataIntegrityViolationException

class AckFileController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ackFileInstanceList: AckFile.list(params), ackFileInstanceTotal: AckFile.count()]
    }

    def create() {
        [ackFileInstance: new AckFile(params)]
    }

    def save() {
        def ackFileInstance = new AckFile(params)
        if (!ackFileInstance.save(flush: true)) {
            render(view: "create", model: [ackFileInstance: ackFileInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'ackFile.label', default: 'AckFile'), ackFileInstance.id])
        redirect(action: "show", id: ackFileInstance.id)
    }

    def show() {
        def ackFileInstance = AckFile.get(params.id)
        if (!ackFileInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ackFile.label', default: 'AckFile'), params.id])
            redirect(action: "list")
            return
        }

        [ackFileInstance: ackFileInstance]
    }

    def edit() {
        def ackFileInstance = AckFile.get(params.id)
        if (!ackFileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ackFile.label', default: 'AckFile'), params.id])
            redirect(action: "list")
            return
        }

        [ackFileInstance: ackFileInstance]
    }

    def update() {
        def ackFileInstance = AckFile.get(params.id)
        if (!ackFileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ackFile.label', default: 'AckFile'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (ackFileInstance.version > version) {
                ackFileInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ackFile.label', default: 'AckFile')] as Object[],
                          "Another user has updated this AckFile while you were editing")
                render(view: "edit", model: [ackFileInstance: ackFileInstance])
                return
            }
        }

        ackFileInstance.properties = params

        if (!ackFileInstance.save(flush: true)) {
            render(view: "edit", model: [ackFileInstance: ackFileInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'ackFile.label', default: 'AckFile'), ackFileInstance.id])
        redirect(action: "show", id: ackFileInstance.id)
    }

    def delete() {
        def ackFileInstance = AckFile.get(params.id)
        if (!ackFileInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ackFile.label', default: 'AckFile'), params.id])
            redirect(action: "list")
            return
        }

        try {
            ackFileInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'ackFile.label', default: 'AckFile'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ackFile.label', default: 'AckFile'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
