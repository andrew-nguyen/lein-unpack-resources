# lein-unpack-resources

A Leiningen plugin that fetches a maven-based jar, unpacks it, and adds it as a
resource

## Usage

Use this for user-level plugins:

Put `[lein-unpack-resources "0.1.1"]` into the `:plugins` vector of your
`:user` profile

Use this for project-level plugins:

Put `[lein-unpack-resources "0.1.1"]` into the `:plugins` vector of your project.clj.

Specify `:unpack-resources {:resource <resource>, :extract-path <path to extract
jar>}`

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
