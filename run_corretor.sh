cd ./lalex
mvn clean package
java -jar target/lalex-1.0-SNAPSHOT-jar-with-dependencies.jar test-cases/entrada/1.ct test-cases/saida/1.out