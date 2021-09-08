.PHONY: build
build:
	docker build \
		-t jclo-7-5-1 \
		.

.PHONY: run
run:
	docker run \
		-it \
		--rm \
		-p 80:8080 \
		--name jclo-7-5-1 \
		jclo-7-5-1