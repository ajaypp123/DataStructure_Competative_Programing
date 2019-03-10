Linklist.exe: Linklist.o Main.o
	gcc -o Linklist.exe Linklist.o Main.o
Linklist.h.gch: Linklist.h
	gcc -c Linklist.h
Linklist.o: Linklist.c Linklist.h.gch
	gcc -c Linklist.c
Main.o: Main.c Linklist.o
	gcc -c Main.c
clean:
	rm -rf *.o *.gch *.exe
