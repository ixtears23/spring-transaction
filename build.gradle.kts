val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false


plugins {
    java
    id ("org.springframework.boot") version "3.3.2"
    id ("io.spring.dependency-management") version "1.1.6"
}

group = "junseok.snr"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation ("org.springframework.boot:spring-boot-starter-web")
        implementation ("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
        compileOnly ("org.projectlombok:lombok")
        implementation ("org.redisson:redisson-spring-boot-starter:3.34.1")
        developmentOnly ("org.springframework.boot:spring-boot-devtools")
        runtimeOnly ("com.h2database:h2")
        runtimeOnly ("com.mysql:mysql-connector-j")
        annotationProcessor ("org.projectlombok:lombok")
        testImplementation ("org.springframework.boot:spring-boot-starter-test")
        testImplementation ("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.3")
        testRuntimeOnly ("org.junit.platform:junit-platform-launcher")
    }

}

tasks.withType<Test> {
    useJUnitPlatform()
}