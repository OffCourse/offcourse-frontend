(ns offcourse.fake-data.courses)

(def raw-courses [{:goal "Become a Frontend Ninja"
               :checkpoints [{:task "Install React"
                              :completed true}
                             {:task "Build a Component"
                              :completed false}
                             {:task "Create an App"
                              :completed false}]}
              {:goal "Improve your Backend Chops"
               :checkpoints [{:task "Install Node"
                              :completed true}
                             {:task "Set up a Route"
                              :completed false}
                             {:task "Add some Middleware"
                              :completed false}
                             {:task "Build an API"
                              :completed false}]}
              {:goal "Get More Street Cred"
               :checkpoints [{:task "Talk Dirty with Reika"
                              :completed false}
                             {:task "Pair with Greg"
                              :completed false}
                             {:task "Scheme with Charlotte"
                              :completed false}
                             {:task "Brawl with Yeehaa"
                              :completed false}]}
              {:goal "Make DevOps Your Thing"
               :checkpoints [{:task "Tame the Command Line"
                              :completed false}
                             {:task "Just Git It"
                              :completed false}
                             {:task "Try a PAAS"
                              :completed false}
                             {:task "Make Containers"
                              :completed false}
                             {:task "Do it All"
                              :completed false}]}])
