
- go build file-name.go

> ## testing
> - time go run file-name.go
> 
> - for linux [sudo apt install time]
> - /usr/bin/time -v go run file-name.go
> 
> - for linux [sudo apt install hyperfine]
> - hyperfine "go run file-name.go"
> - hyperfine --warmup 3 "go run function3.go" [does testing 3 times]
> - build the exe format, and hyperfine that. 
> 
> #### test > Tool  
> correctness >	go test  
> speed	> go test -bench  
> memory > -benchmem  
> CPU hotspots >	pprof  
> RAM leaks >	pprof heap  
> load testing >	wrk / hey  
> real performance >	built binary + hyperfine  
> live monitoring >	/debug/pprof  