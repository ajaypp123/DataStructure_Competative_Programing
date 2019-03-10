stack.exe: stack.o main.o
	gcc -o stack.exe stack.o main.o
stack.h.gch: stack.h
	gcc -c stack.h
stack.o: stack.c stack.h.gch
	gcc -c stack.c
main.o: main.c stack.o
	gcc -c main.c
clean:
	rm -rf *.o *.gch *.exe
