# simple-roomba-test

# Build
build this project by executing: make assemble

# Run
run this application by executing: make run ARG="-Ddb_location=~/test_db"
where -Ddb_location parameter indicates a local directory where the H2 database will be placed

# API
while the application is still running

execute roomba
curl http://localhost:8080/startRoomba -X PUT -H "Content-Type: application/json" -d '{"roomSize" : [5, 5], "coords" : [1, 2], "patches" : [ [1, 0],[2, 2],[2, 3] ], "instructions" : "NNESEESWNWW" }'

Retrieve input data
curl http://localhost:8080/inputs

Retrieve output data
curl http://localhost:8080/outputs

# Stop
Exit running app simply by pressing Crtl + C