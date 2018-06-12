const fs = require('fs');
const http = require('http');

const server = http.createServer((req, res) => {
    var url = req.url.substring(1, req.url.length);
    if (url === '') url = 'index.html';
    var typ = url.substring(url.lastIndexOf('.') + 1, url.length);
    console.log("URL - " + url + " TYP - " + typ);
    res.writeHead(200, {'Content-Type': 'text/' + typ +'; charset=utf8'});
    fs.createReadStream(url).pipe(res);
}).listen(2002, () => console.log("SERVER START"));