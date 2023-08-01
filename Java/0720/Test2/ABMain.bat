javac ABMain.java
mkdir sub
move AAA.class sub\AAA.class
move BBB.class sub\BBB.class
set classpath=.;.\sub
java ABMain
pause
