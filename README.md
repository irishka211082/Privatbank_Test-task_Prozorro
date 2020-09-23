# Prepare test environment:

### Run PostreSQL docker container
```
docker run -d --name test_db -v my_dbdata:/var/lib/postgresql/data -p 54320:5432 postgres:11
```

### Connect to PostreSQL docker container
```
docker exec -it test_db bash
```

### Create database
```
psql -U postgres
```
```
CREATE DATABASE prozorro;
```


# Service endpoints:

### Parse and flush all items to db from external url:
```
curl -X POST \
  http://localhost:8081/api/v1/classifier \
  -H 'cache-control: no-cache'
```

### Parse and update all items to db from external url:
```
curl -X PUT \
  http://localhost:8081/api/v1/classifier \
  -H 'cache-control: no-cache'
```

### Get All items:
```
curl -X GET \
  http://localhost:8081/api/v1/classifier \
  -H 'cache-control: no-cache'
```

### Get Item by id:
```
curl -X GET \
  http://localhost:8081/api/v1/classifier/03110000-5 \
  -H 'cache-control: no-cache'
```

### Get Children items:
```
curl -X GET \
  http://localhost:8081/api/v1/classifier/03110000-5/children \
  -H 'cache-control: no-cache'
```
