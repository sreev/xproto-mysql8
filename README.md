# xproto-mysql8
Java Connecting to MySQLv8 using X Protocol (alternate to jdbc)


Download MySQL 8 (dev):

https://cdn.mysql.com//Downloads/MySQL-8.0/mysql-8.0.1-dmr-macos10.12-x86_64.tar.gz


Open terminal:

> $ tar -xf mysql-8.0.1-dmr-macos10.12-x86_64.tar.gz
> $ cd mysql-8.0.1-dmr-macos10.12-x86_64
> $ bin/mysqld --initialize --basedir=~/mysql-8.0.1-dmr-macos10.12-x86_64 --datadir=~/data
> $ bin/mysqld_safe


Download world_x database:

http://downloads.mysql.com/docs/world_x-db.tar.gz

Open another terminal:

> $ tar -xf world_x-db.tar.gz
> $ cd mysql-8.0.1-dmr-macos10.12-x86_64
> $ bin/mysq -u root -p
> mysql> source ~/world_x-db/world_x.sql;
> mysql> install plugin mysqlx soname 'mysqlx.so';


Open another terminal:

> $ git clone <this repo>
> $ mvn clean package
> $ mvn exec:java -Dexec.mainClass="org.sreev.db.mysql.Main" -Dexec.args="<password for db user 'root'>"

Sample output:

> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - ID = 3881
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - Name = Augusta-Richmond County
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - CountryCode = USA
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - District = Georgia
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - Info = {"Population": 199775}
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - ID = 3909
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - Name = Arlington
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - CountryCode = USA
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - District = Virginia
> 14:30:49.004 [org.sreev.db.mysql.Main.main()] DEBUG org.sreev.db.mysql.Main - Info = {"Population": 174838}


# Resources
https://dev.mysql.com/doc/x-devapi-userguide/en/

https://dev.mysql.com/doc/refman/8.0/en/

https://dev.mysql.com/doc/index-other.html

https://dev.mysql.com/doc/refman/5.7/en/document-store-setting-up.html
