def call(ip,user,credID){
    sshagent([credID]) {
    // some block
      sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat8/webapps/app.war"
     sh "ssh ${user}@${ip} /opt/tomcat8/bin/startup.sh"
     sh "ssh ${user}@${ip} /opt/tomcat8/bin/shutdown.sh"

}
