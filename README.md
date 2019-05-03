# xml-path-extract

Small util that prints all the reachable xpaths of tagsinside an XML file.

## Usage

For example:

`lein run <xml>`

Or:

`lein uberjar; java -jar target/xpe.jar <xml>`

## Example

`lein run https://www.theguardian.com/world/rss`

prints:

```clojure
("rss/channel/copyright"
 "rss/channel/dc:date"
 "rss/channel/dc:language"
 "rss/channel/dc:rights"
 "rss/channel/description"
 "rss/channel/image/link"
 "rss/channel/image/title"
 "rss/channel/image/url"
 "rss/channel/item"
 "rss/channel/item/category"
 "rss/channel/item/dc:creator"
 "rss/channel/item/dc:date"
 "rss/channel/item/description"
 "rss/channel/item/guid"
 "rss/channel/item/link"
 "rss/channel/item/media:content/media:credit"
 "rss/channel/item/pubDate"
 "rss/channel/item/title"
 "rss/channel/language"
 "rss/channel/link"
 "rss/channel/pubDate"
 "rss/channel/title")
```
