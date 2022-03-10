# How to run RemoteRecorderTest

1. Build the files in this directory. Using my Eclipse setup, built class files will then be located in `target/test-classes/remote`
2. Run `$ start rmiregistry` in the dir `target/test-classes`.
3. To start the server: Run `$ java -classpath target/test-classes -Djava.rmi.server.codebase=file:target/test-classes remote.Server` Standing in the projects root directory.
4. Run the tests in RemoteRecorderTest

