import editransactions.*
import java.util.*
import java.lang.*

class BootStrap {

    def init = { servletContext ->


        def  userRole = login.SecRole.findByAuthority("ROLE_USER")?: new login.SecRole(authority:"ROLE_USER").save()
        def  adminRole = login.SecRole.findByAuthority("ROLE_ADMIN")?: new login.SecRole(authority:"ROLE_ADMIN").save()
        def adminUser = login.SecUser.findByUsername('admin') ?: new login.SecUser(
                username: 'admin',
                password: ('admin'),
                enabled: true).save(failOnError: true)

        if (!adminUser.authorities.contains(userRole)) {
            login.SecUserSecRole.create adminUser, userRole
        }


    }
    def destroy = {
    }
}
