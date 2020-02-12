FROM node:12
RUN npm install yarn

WORKDIR /usr/src/app
COPY package.json yarn.lock ./
RUN yarn install --frozen-lockfile

COPY index.js launch.sh wait-for-it.sh ./
EXPOSE 4000
ENTRYPOINT ["./launch.sh"]
