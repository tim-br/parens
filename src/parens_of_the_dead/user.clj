(ns parens-of-the-dead.user
  (:require [reloaded.repl :refer [system reset stop]]
            [parens-of-the-dead.core]))

(reloaded.repl/set-init! #'parens-of-the-dead.core/create-system)