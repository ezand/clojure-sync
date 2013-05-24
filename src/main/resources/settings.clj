{:google-api {:enabled? true
              :client_id "{MY_CLIENT_ID}"
              :client_secret "{MY_SECRET}"}

 :picasa {:enabled? true
          :watched-folders [{:file-filter "*.*" :events [:create :modify ] :path "/Users/eiriksand/temp"}
                            {:file-filter "*.*" :events [:create :modify ] :path "/Users/eiriksand/Pictures"}]}}
