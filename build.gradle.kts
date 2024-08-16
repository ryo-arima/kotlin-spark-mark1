plugins {
    kotlin("jvm") version "1.8.10"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.10")
    implementation("org.freemarker:freemarker:2.3.31")
    implementation("com.sparkjava:spark-core:2.9.3")
    implementation("com.github.ajalt.clikt:clikt:4.0.0")
    implementation("com.akuleshov7:ktoml-core:0.4.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

sourceSets {
    main {
        kotlin.setSrcDirs(listOf("src"))
    }
}

application {
    mainClass.set("cmd.client.AdminKt")
}


buildDir = file("bin")

tasks.register("copyTemplateFiles") {
    group = "build"
    doLast {
        copy {
            from("src/pkg/client/template/")
            into("$buildDir/template/")
        }
        println("Copy template files")
    }
}

tasks.register<Copy>("copyDependencies") {
    from(configurations.runtimeClasspath)
    into("$buildDir/libs")
}

tasks.named<CreateStartScripts>("startScripts") {
    dependsOn("copyDependencies")
    doLast {
        val batFile = File("${outputDir}/${applicationName}.bat")
        if (batFile.exists()) {
            batFile.delete()
        }
    }
}

tasks.named("build") {
    dependsOn("copyTemplateFiles")
    dependsOn("copyDependencies")
    dependsOn("jarAdmin")
    dependsOn("jarApp")
    dependsOn("jarAnonymous")
    dependsOn("jarServer")
}

tasks.register<Jar>("jarServer") {
    archiveBaseName.set("server")
    archiveVersion.set("1.0.0")
    archiveClassifier.set("")
    archiveFileName.set("server.jar")
    manifest {
        attributes["Main-Class"] = "cmd.server.MainKt"
    }
    from(sourceSets.main.get().output)
    dependsOn("classes")
}

tasks.register<Jar>("jarAdmin") {
    archiveBaseName.set("admin-client")
    archiveVersion.set("1.0.0")
    archiveClassifier.set("")
    archiveFileName.set("admin-client.jar")
    manifest {
        attributes["Main-Class"] = "cmd.client.AdminKt"
    }
    from(sourceSets.main.get().output)
    dependsOn("classes")
}

tasks.register<Jar>("jarApp") {
    archiveBaseName.set("app-client")
    archiveVersion.set("1.0.0")
    archiveClassifier.set("")
    archiveFileName.set("app-client.jar")
    manifest {
        attributes["Main-Class"] = "cmd.client.AppKt"
    }
    from(sourceSets.main.get().output)
    dependsOn("classes")
}

tasks.register<Jar>("jarAnonymous") {
    archiveBaseName.set("anonymous-client")
    archiveVersion.set("1.0.0")
    archiveClassifier.set("")
    archiveFileName.set("anonymous-client.jar")
    manifest {
        attributes["Main-Class"] = "cmd.client.AnonymousKt"
    }
    from(sourceSets.main.get().output)
    dependsOn("classes")
}