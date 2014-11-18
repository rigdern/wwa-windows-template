;; Copyright (c) Microsoft Open Technologies, Inc. All rights reserved.
;; This program is made available under the terms of the Eclipse Public
;; License v1.0 which accompanies this distribution, and is available at
;; http://www.eclipse.org/legal/epl-v10.html


(ns leiningen.new.wwa-windows
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.string :as string]
            [clojure.java.io :as io])
  (:import java.util.UUID))

(def render (renderer "wwa-windows"))
(defn bin-render [template]
  (let [path (string/join "/" ["leiningen" "new" "wwa_windows" template])]
    (io/input-stream (io/resource path))))

(defn wwa-windows [name]
  (let [uuid (str (UUID/randomUUID))
        data {:name name
              :sanitized (name-to-path name)
              :uuid uuid
              :bracketed-uuid (str "{" uuid "}")
              :publisher (or (System/getenv "USERNAME") "somebody")}]
    (main/info "Generating fresh 'lein new' wwa-windows project.")
    (->files data
             ["{{name}}.sln" (render "my-project.sln" data)]
             ["{{name}}/{{name}}.jsproj" (render "my-project/my-project.jsproj" data)]
             ["{{name}}/package.appxmanifest" (render "my-project/package.appxmanifest" data)]
             ["{{name}}/default.html" (render "my-project/default.html" data)]
             ["{{name}}/js/winstore-closurecompat.js" (render "my-project/js/winstore-closurecompat.js" data)]
             ["{{name}}/js/winstore-jscompat.js" (render "my-project/js/winstore-jscompat.js" data)]
             ["{{name}}/css/default.css" (render "my-project/css/default.css" data)]
             ["{{name}}/project.clj" (render "my-project/project.clj" data)]
             ["{{name}}/src/{{sanitized}}/core.cljs" (render "my-project/src/core.cljs" data)]
             ["{{name}}/images/logo.scale-100.png" (bin-render "my-project/images/logo.scale-100.png")]
             ["{{name}}/images/smalllogo.scale-100.png" (bin-render "my-project/images/smalllogo.scale-100.png")]
             ["{{name}}/images/splashscreen.scale-100.png" (bin-render "my-project/images/splashscreen.scale-100.png")]
             ["{{name}}/images/storelogo.scale-100.png" (bin-render "my-project/images/storelogo.scale-100.png")])))
