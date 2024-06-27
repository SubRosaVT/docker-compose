
echo "Applying PVs ..."

echo "Applying zookeeper-pv.yaml ..."
kubectl apply -f zookeeper/zookeeper-pv.yaml
echo "Applying kafka-pv.yaml ..."
kubectl apply -f kafka/kafka-pv.yaml
echo "Applying mongodb-pv.yaml ..."
kubectl apply -f mongodb/mongodb-pv.yaml

echo "Applying PVCs ..."

echo "Applying zookeeper-pvc.yaml"
kubectl apply -f zookeeper/zookeeper-pvc.yaml
echo "Applying kafka-pvc.yaml"
kubectl apply -f kafka/kafka-pvc.yaml
echo "Applying mongodb-pvc.yaml"
kubectl apply -f mongodb/mongodb-pvc.yaml

echo "Applying configmaps ..."

echo "Applying mongo-init-configmap.yaml"
kubectl apply -f mongodb/mongodb-init-configmap.yaml


echo "Applying zookeeper ..."

echo "Applying zookeeper-deployment.yaml"
kubectl apply -f zookeeper/zookeeper-deployment.yaml
echo "Applying zookeeper-service.yaml"
kubectl apply -f zookeeper/zookeeper-service.yaml

echo "Applying kafka ..."

echo "Applying kafka-deployment.yaml"
kubectl apply -f kafka/kafka-deployment.yaml
echo "Applying kafka-service.yaml"
kubectl apply -f kafka/kafka-service.yaml

echo "Applying mongodb ..."

echo "Applying mongodb-deployment.yaml"
kubectl apply -f mongodb/mongodb-deployment.yaml
echo "Applying mongodb-service.yaml"
kubectl apply -f mongodb/mongodb-service.yaml

echo "Applying myapp..."

echo "Applying myapp-deployment.yaml"
kubectl apply -f myapp/myapp-deployment.yaml
echo "Applying myapp-service.yaml"
kubectl apply -f myapp/myapp-service.yaml

echo "Applying ingress ..."

echo "Applying ingress.yaml"
kubectl apply -f myapp/myapp-ingress.yaml
