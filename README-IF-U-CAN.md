Docker:

!!! I have to reverify docker-compose!!!
to use for running in IDE src/main/resources/application-local.properties
to run with docker-compose up : src/main/resources/application-qa.yaml
change the profile in src/main/resources/application.properties

Kubernetes on minikube:
one can find commands in kubernetes/kubernetes-deployment.sh

local dns support patch:

cat /etc/hosts
...
192.168.49.2    my-demo-app.com
...



