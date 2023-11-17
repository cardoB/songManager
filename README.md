Song Manager
A simple program designed to manage a collection of songs from/to a text file
Songs Manager 

The Song Manager application is a simple Java program designed to manage a collection of songs. It allows users to interactively add songs, remove songs, display all songs, and search for specific songs within the collection. The application provides a menu-driven interface that enables navigation and interaction with a file located at the project folder called Songs.txt. 
Upon launching the application, the file gets automatically open and loaded, ready for the user to interact with; the user, with the help of a menu, can do the following: 
* add a song: not allowing duplicates  
* remove a song: through each song’s index  
* display all songs: in tabular form  
* search for a song: with a keyword  
* exit

 To ensure data persistence, any modifications made by the user, such as adding or removing songs, are saved back to the same text file from which the songs were initially loaded only if the exit command gets executed. This ensures that the changes made by the user are preserved and can be accessed in subsequent program runs.  Overall, the Song Manager application offers a straightforward and intuitive way to manage a collection of songs, making it easy for users to organize and access their favorite music.  The songs are stored using a parent class called Song, and a child class called SongSpecs. 
