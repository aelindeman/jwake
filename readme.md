# jwake #

jwake wakes up machines on your local network.

jwake is a little Java GUI that can store machines’ MAC addresses and effortlessly wake computers on your network, without leaving the comfort of your chair — because pressing power buttons is for chumps!

## Dependencies ##

  * Java 6

## Usage ##

jwake can be run from the command line like:

	java -jar jwake.jar <storage>

If `<storage>` is specified, it should point to the location of a CSV of stored machines (formatted as `name,xx-xx-xx-xx-xx-xx`). If it does not exist, it will be created. If it isn't specified, jwake will use "machines.txt" in the same directory.

## Known issues ##

  * Uses JSwing (ew, gross!).

## More information ##

  * Author: Alex Lindeman [[aelindeman](http://github.com/aelindeman/)]