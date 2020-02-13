FROM node:12
RUN npm install yarn
EXPOSE ${PORT}

WORKDIR /usr/src/app
COPY package.json yarn.lock ./
RUN yarn install --frozen-lockfile

COPY index.js launch.sh ./
ENTRYPOINT ["./launch.sh"]
