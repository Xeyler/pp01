submission: writeup/writeup.pdf
	mkdir -p submission
	cp writeup/writeup.pdf code/writeup.pdf
	cd code/ && zip -r brigham_campbell_pp01.zip . && rm writeup.pdf
	mv code/brigham_campbell_pp01.zip submission/brigham_campbell_pp01.zip

writeup/writeup.pdf:
	$(MAKE) -C writeup/

.PHONY: clean
clean:
	rm -f submission/brigham_campbell.zip
	$(MAKE) clean -C writeup/
