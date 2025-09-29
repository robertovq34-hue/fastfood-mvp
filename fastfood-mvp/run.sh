#!/usr/bin/env bash
mvn package
java -cp target/fastfood-mvp-1.0-SNAPSHOT.jar com.usil.fastfood.Main
