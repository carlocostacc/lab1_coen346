#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    FILE *source, *dest;
    char ch;

    if (argc != 3) {
        printf("Usage: %s <source file> <destination file>\n", argv[0]);
        return 1;
    }

    source = fopen(argv[1], "r");
    if (source == NULL) {
        printf("Error opening source file\n");
        return 1;
    }

    dest = fopen(argv[2], "w");
    if (dest == NULL) {
        printf("Error opening destination file\n");
        fclose(source);
        return 1;
    }

    while (!feof(source)) {
	ch = fgetc(source);
        fputc(ch, dest);
    }

    printf("File copied successfully\n");

    fclose(source);
    fclose(dest);

    return 0;
}
