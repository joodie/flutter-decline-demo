# flutter-decline-demo

A simple CRUD(Create, Read, Update and Delete) address book demo using [flutter][flutter],
[clj-decline][decline], [pretzel][pretzel] and [compojure][compojure].

Mostly written on the train from Hamburg to Utrecht after the
[European Lisp Symposium 2011][ELS2011].

## Usage

     lein deps
     lein run

then point your browser at `http://localhost:8080/`

use `lein run [port-number]` to run the demo on another port

## Changes

v1.1.0 

  * some code cleanup, now uses [pretzel][pretzel] in some
    validations.

v1.0.0

  * initial release

## License

Copyright (C) 2010 Joost Diepenmaat, Zeekat Softwareontwikkeling

Distributed under the Eclipse Public License, the same as Clojure.

[ELS2011]: http://www.european-lisp-symposium.org/
[compojure]: https://github.com/weavejester/compojure
[decline]: https://github.com/joodie/clj-decline
[flutter]: https://github.com/joodie/flutter
[pretzel]: https://github.com/joodie/pretzel
