nohup java -jar target/parkShare-1.0-SNAPSHOT.jar > parkshare.log 2> parkshare-err.log &
tail -f parkshare.log
