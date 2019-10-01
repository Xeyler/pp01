pdf: timings.csv
	pandoc -o writeup.pdf writeup.md

timings.csv:
	gradle run -p ../code/ -q > timings.csv

.PHONY: clean
clean:
	rm -f writeup.pdf timings.csv
