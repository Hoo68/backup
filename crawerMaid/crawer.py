import urllib2
import urllib
import re
import mysql.connector
from cookielib import CookieJar


def getUserDetail(url):
  request = urllib2.Request(url)
  cj = CookieJar()
  opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
  try:
    response = opener.open(request)
    content = response.read()
    pattern = re.compile('listagency\.asp\?id\=(.*?)\">', re.S)
    return re.findall(pattern, content)

  except urllib2.URLError, e:
    print e


url = "http://www.bestmaid.com.sg/agencies.asp"

result = getUserDetail(url)
urlSet = set()
if len(result) != 0:
  for val in result:
    # ucontent = 'http://www.bestmaid.com.sg/listagency.asp?id=' + unicode(val, 'utf-8')
    id = re.findall(r'\d+', val)[0]
    detailUrl = 'http://www.bestmaid.com.sg/listagency.asp?id=' + id
    urlSet.add(detailUrl)
else:
  print "can not get page !"

def getDetail(urlSet):
  for url in urlSet:
    f = urllib.urlopen(url)
    html = f.read().replace('\n', '')
    photo = getPhoto(html)
    address = getAddress(html)
    tel = getTel(html)
    print photo
    print address
    print tel

def getPhoto(html):
  photo_pattern = re.compile('<td colspan=\"2\" align=\"center\"><img src=\"(.*?)\" class=\"agenciesLogo\"', re.S)
  return re.findall(photo_pattern, html)

def getAddress(html):
  address_pattern = re.compile('<meta name=\"description\" CONTENT=\"(.*?)\">', re.S)
  return re.findall(address_pattern, html)

def getTel(html):
  print html
  tel_pattern = re.compile('Tel:</th><td>(.*?)', re.S)
  return re.findall(tel_pattern, html)


url_set = set()
detail = 'http://www.bestmaid.com.sg/listagency.asp?id=81'
url_set.add(detail)
getDetail(url_set)


