'''import urllib3

for line in urllib3.proxy_from_url('https://raw.githubusercontent.com/sithu/assignment1-config-example/master/dev-config.yml'):
    print line
'''

import urllib3
http = urllib3.PoolManager()
r = http.request('GET', 'https://raw.githubusercontent.com/sithu/assignment1-config-example/master/dev-config.yml')
print r.data
