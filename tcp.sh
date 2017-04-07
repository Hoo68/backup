#/bin/bash
#sudo tcpdump -l -A | egrep -i 'pass=|pwd=|log=|login=|user=|username=|pw=|passw=|passwd=|password=|pass:|user:|username:|password:|login:|pass |user ' --color=auto --line-buffered -B20
#sudo tcpdump -l -A | egrep -i 'pass=|pwd=|log=|login=|pw=|passw=|passwd=|password=|pass:|password:|login:|pass ' --color=auto --line-buffered -B20
sudo tcpdump -w file.cap 
