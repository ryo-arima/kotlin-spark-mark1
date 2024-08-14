s:
	git add .
	commit-emoji
	git push origin develop
run:
	java -cp "bin/libs/kotlin-spark-mark1.jar:bin/libs/*" cmd.client.AdminKt
