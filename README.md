```
docker run --rm -d -p 3306:3306 --name mysql -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test mysql:latest
nmp install
node src/server.js
```
