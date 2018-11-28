# PolyElectives

To Run SONAR locally:

mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install sonar:sonar \
  -Dsonar.projectKey=Electives \
    -Dsonar.organization=307group \
      -Dsonar.host.url=https://sonarcloud.io \
        -Dsonar.login=25b54f1c1407f631d2555a2e71853e6aac98f658

Travis Site: https://travis-ci.org/pmkramer/PolyElectives

Sonar Site: https://sonarcloud.io/organizations/307group/projects
