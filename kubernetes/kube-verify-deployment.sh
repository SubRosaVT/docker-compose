echo "Verifying deployment..."

echo "Getting pvs"
kubectl get pv

echo "Getting pvcs"
kubectl get pvcs

echo "Getting deployments"
kubectl get deployment

echo "Getting pods ..."
kubectl get pods

echo "Getting svcs ..."
kubectl get svc

echo "Getting ingress ..."
kubectl get ingress
