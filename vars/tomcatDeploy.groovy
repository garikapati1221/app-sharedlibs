def call(ips,user,credID){
    sshagent([credID]) {
        ips.each {
            echo "Deploying on ${it}"
            sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${it}:/opt/tomcat8/webapps/app.war"
            sh "ssh ${user}@${it} /opt/tomcat8/bin/startup.sh"
            sh "ssh ${user}@${it} /opt/tomcat8/bin/shutdown.sh"
        }
      

}
}
