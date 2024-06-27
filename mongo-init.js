// mongo-init.js

db = db.getSiblingDB('admin');
db.grantRolesToUser("root", [{ role: "readWrite", db: "messages" }]);

db = db.getSiblingDB('messages');
db.messages.insertOne({
  _id: '61d5a828-23b7-4fe6-87cc-2b09dd8f3975',
  msg: 'test',
  _class: 'com.dockercomposr.dockercompose.entities.MessageEntity'
});
