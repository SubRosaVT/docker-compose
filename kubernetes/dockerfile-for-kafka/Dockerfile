FROM wurstmeister/kafka:latest
# Update the package list and install dnsutils
RUN apt-get update && apt-get install -y dnsutils && apt-get clean

# Clean up APT when done
RUN rm -rf /var/lib/apt/lists/*


