(ns labrepl-test
  (:use clojure.test
        labrepl
        labrepl.lab))

(testing "rendering the labs"
  (doseq [lab (all)]
    (let [url (lab-url lab)
          resp (app {:request-method :get :uri url})]
      (is (= {:status 200 :headers  {"Content-Type" "text/html"}}
                 (select-keys resp [:status :headers]))))))
