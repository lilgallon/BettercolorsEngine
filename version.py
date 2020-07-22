import sys
import os

if __name__ == '__main__':
    if len(sys.argv) != 2 or (sys.argv[1] != '1.8.9' and sys.argv[1] != '1.16.1'):
        print('Usage: ./version.py 1.8.9 or ./version.py 1.16.1')
    elif sys.argv[1] == '1.8.9':
        # use build.gradle 1.8.9
        if os.path.isfile('build.gradle 1.8.9'):
            os.rename('build.gradle', 'build.gradle 1.16.1')
            os.rename('build.gradle 1.8.9', 'build.gradle')
            print('Replaced build.gradle 1.16.1 by build.gradle 1.8.9')
        else:
            print('build.gradle 1.8.9 is already used')
    else:
        # use build.gradle 1.16.1
        if os.path.isfile('build.gradle 1.16.1'):
            os.rename('build.gradle', 'build.gradle 1.8.9')
            os.rename('build.gradle 1.16.1', 'build.gradle')
            print('Replaced build.gradle 1.8.9 by build.gradle 1.16.1')
        else:
            print('build.gradle 1.16.1 is already used')
