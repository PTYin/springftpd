# TBD

A minimum FTP server based on Springboot.

## Implementation
The server strictly conforms to the minimal requirements defined by [RFC-959](https://www.w3.org/Protocols/rfc959/5_Declarative.html).

    In order to make FTP workable without needless error messages, the
    following minimum implementation is required for all servers:
    
     TYPE - ASCII Non-print
     MODE - Stream
     STRUCTURE - File, Record
     COMMANDS - USER, QUIT, PORT,
                TYPE, MODE, STRU,
                  for the default values
                RETR, STOR,
                NOOP.
    
    The default values for transfer parameters are:
    
     TYPE - ASCII Non-print
     MODE - Stream
     STRU - File
    
    All hosts must accept the above as the standard defaults.