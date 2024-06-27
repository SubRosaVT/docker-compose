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

Problem(1)

for:
http://my-demo-app.com:30081/api/v1/msg
returns 
UIID false [false cause failed to call Kafka, but yes we are getting to the app controller]

but not exposing port as expected:
http://my-demo-app.com/api/v1/msg

Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Thu Jun 27 06:46:22 UTC 2024
There was an unexpected error (type=Not Found, status=404).

Other Problems:
networking from myapp for kafka and mongo
atm deployments are able to raise the pods 

